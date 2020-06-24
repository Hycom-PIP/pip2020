import numpy as np
import pandas_datareader as web
import pandas as pd
from datetime import date

from sklearn.preprocessing import MinMaxScaler
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import LSTM, Dense, Dropout

def split_sequences(seq, n_steps, n_steps_out):
    X,y = [], []
    for i in range(len(seq)):
        end = i + n_steps
        out_end = end + n_steps_out
        if out_end > len(seq):
            break
        seq_x, seq_y = seq[i:end], seq[end:out_end]
        X.append(seq_x)
        y.append(seq_y)
    return np.array(X),np.array(y)

def learn_and_predict(stock_name, from_date, to_date):
    df = web.DataReader(stock_name, data_source='yahoo', start=from_date, end=to_date)
    data = df.filter(['Close'])
    scaler = MinMaxScaler()
    df = pd.DataFrame(scaler.fit_transform(data), columns=data.columns, index=data.index)
    n_per_in = 30
    n_per_out = 10
    n_features = 1
    X, y = split_sequences(list(df.Close), n_per_in, n_per_out)
    X = X.reshape(X.shape[0], X.shape[1], n_features)
    model = Sequential()
    model.add(LSTM(30,activation="softsign", return_sequences=True, input_shape=(n_per_in, n_features)))
    model.add(LSTM(10,activation="softsign", return_sequences=True))
    model.add(LSTM(10,activation="softsign", return_sequences=True))
    model.add(LSTM(10,activation="softsign", return_sequences=True))
    model.add(LSTM(10,activation="softsign", return_sequences=True))
    model.add(LSTM(10,activation="softsign", return_sequences=True))
    model.add(LSTM(10,activation="softsign"))
    model.add(Dense(n_per_out))
    model.compile(optimizer='adam', loss='mse', metrics=['accuracy'])
    model.fit(X, y, batch_size=32, epochs=10, validation_split=0.1)
    yhat = model.predict(np.array(df.tail(n_per_in)).reshape(1, n_per_in, n_features)).tolist()[0]
    yhat = scaler.inverse_transform(np.array(yhat).reshape(-1,1)).tolist()
    return pd.DataFrame(yhat, index=pd.date_range(start=df.index[-1], periods=len(yhat),freq="D"), columns=df.columns)