# -*- coding: utf-8 -*-

#ソケットAPIモジュールのインポート
import socket
import sys

#HOST="192.168.100.108"
PORT=50000
BUFSIZE=4096

#メイン実行部
#ソケットの作成
client = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
#サーバーとの接続
host=input("接続先サーバ")
host=socket.gethostbyname(host)
print(host)
try:
    client.connect((host,PORT))
except:
    print("接続できません")
    sys.exit()
#サーバへのメッセージ送信
msg = input("メッセージ入力 :")
client.sendall(msg.encode("utf-8"))
#サーバからのメッセージ受信
data = client.recv(BUFSIZE)
print(data.decode("UTF-8"))
#コネクションクローズ
client.close()
#client0.pyの終わり
