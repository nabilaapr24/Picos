import pandas as pd
import tensorflow as tf
from flask import Flask, request, jsonify
#from db import  add_predict

model = tf.keras.models.load_model('modelnew.h5')
# Define the column names
features = ['BMI', 'Blood Group', 'Cycle(R/I)',  'Pregnant(Y/N)',
            'No. of aborptions', 'Waist:Hip Ratio', 'Weight gain(Y/N)', 'hair growth(Y/N)',
            'Skin darkening (Y/N)', 'Hair loss(Y/N)', 'Pimples(Y/N)', 'Fast food (Y/N)',
            'Reg.Exercise(Y/N)', 'age_category', 'marriage_category']

# Define the category labels
category_labels = {0: 'Non-PCOS', 1: 'PCOS'}

# Initialize Flask app
app = Flask(__name__)

@app.route('/')
def home():
    return jsonify({'message': 'Welcome to the API'})
# Define the route for prediction
@app.route('/predict', methods=['POST'])
def predict():
    # Get the input data from the request
    input_data = request.get_json()
    #add_predict(input_data)
    for feature in input_data:
        value = input_data[feature]
        if isinstance(value, str):
            try:
                input_data[feature] = float(value)
            except ValueError:
                return jsonify({'error': f'Invalid value for {feature}'})
    
    # Create a DataFrame from the input data
    user_df = pd.DataFrame([input_data], columns=features)

    # Make predictions using the user input 
    predictions = predict_pcos(model, user_df)

    # Return the predictions as a JSON response
    response = {'predictions': predictions}
    return jsonify(response)
    

# Define the function for making predictions
def predict_pcos(model, data):
    # Preprocess the input data
    input_data = data[features]  # Select the relevant columns for prediction

    # Make predictions
    predictions = model.predict(input_data) # Probabilities of the positive class

    # Convert the probabilities to categories based on the threshold
    predicted_categories = ['PCOS' if prob > 0.5 else 'Non-PCOS' for prob in predictions]

    # Return the predicted categories
    return predicted_categories

# Run the Flask app
if __name__ == '__main__':
    app.run(debug=True)
