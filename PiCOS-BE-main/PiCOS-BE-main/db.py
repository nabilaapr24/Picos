#db.py
import os
import pymysql
from flask import jsonify

db_user = os.environ.get('CLOUD_SQL_USERNAME')
db_password = os.environ.get('CLOUD_SQL_PASSWORD')
db_name = os.environ.get('CLOUD_SQL_DATABASE_NAME')
db_connection_name = os.environ.get('CLOUD_SQL_CONNECTION_NAME')

#generate an open connection to the database function
def open_connection():
    unix_socket = '/cloudsql/{}'.format(db_connection_name)
    conn = pymysql.connect(user=db_user, password=db_password, unix_socket=unix_socket, db=db_name)
    return conn

def get_predict():
    conn = open_connection()
    with conn.cursor() as cursor:
        cursor.execute('SELECT * FROM PiCOS-userdata;')
        results = cursor.fetchall()
        if results > 0:
            return jsonify(results)
        else:
            results = 'No results found'
        conn.commit()
    conn.close()
    return results

def add_predict(data):
    conn = open_connection()
    with conn.cursor() as cursor:
        cursor.execute('INSERT INTO PiCOS-userdata (BMI, Blood_Group, Cycle, Pregnant, No_of_aborptions, Waist_Hip_Ratio, Weight_gain, hair_growth, Skin_darkening, Hair_loss, Pimples, Fast_food, Reg_Exercise, age_category, marriage_category) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s,%s,%s,%s,%s,%s,%s);'
                        (data['BMI'], data['Blood_Group'], data['Cycle'], 
                        data['Pregnant'], data['No_of_aborptions'], data['Waist_Hip_Ratio'], 
                        data['Weight_gain'], data['hair_growth'], data['Skin_darkening'], data['Hair_loss'], 
                        data['Pimples'], data['Fast_food'], 
                        data['Reg_Exercise'], data['age_category'], data['marriage_category']))
        conn.commit()
    conn.close()
    return 'success'
        
def delete_predict(id):
    conn = open_connection()
    with conn.cursor() as cursor:
        cursor.execute('DELETE FROM PiCOS-userdata WHERE id=%s;', (id))
        conn.commit()
    conn.close()
    return 'success'

def update_predict(id, data):
    conn = open_connection()
    with conn.cursor() as cursor:
        cursor.execute('UPDATE PiCOS-userdata SET BMI=%s, Blood_Group=%s, Cycle=%s, Pregnant=%s, No_of_aborptions=%s, Waist_Hip_Ratio=%s, Weight_gain=%s, hair_growth=%s, Skin_darkening=%s, Hair_loss=%s, Pimples=%s, Fast_food=%s, Reg_Exercise=%s, age_category=%s, marriage_category=%s WHERE id=%s;'
                       (data['BMI'], data['Blood_Group'], data['Cycle'], 
                        data['Pregnant'], data['No_of_aborptions'], data['Waist_Hip_Ratio'], 
                        data['Weight_gain'], data['hair_growth'], data['Skin_darkening'], data['Hair_loss'], 
                        data['Pimples'], data['Fast_food'], 
                        data['Reg_Exercise'], data['age_category'], data['marriage_category'], id))
        conn.commit()
    conn.close()
    return 'success'
