# -*- coding: utf-8 -*-

#ソケットAPIモジュールのインポート
import socket

HOST="localhost"
#HOST="192.168.100.108"
PORT=50000
BUIFSIZE=4096

#メイン実行部
#ソケットの作成
client = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
#サーバーとの接続
client.connect((HOST,PORT))
#サーバからのメッセージ受信
data = client.recv(BUIFSIZE)
print(data.decode("UTF-8"))
#コネクションクローズ
client.close()
#client0.pyの終わり
