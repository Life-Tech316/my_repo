# -*- coding: utf-8 -*-


#ソケットAPIモジュールのインポート
import socket
import datetime

#グローバル変数
#ポート番号変数

PORT = 50000
BUFSIZE = 4096
#メイン実行部
#ソケットの作成
server = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
#アドレス設定
server.bind(("",PORT))
#サーバーの待ち受け
server.listen()

#クライアントへの対応処理
while True:
    client,addr = server.accept()
    msg = str(datetime.datetime.now())
    print(msg,"接続要求あり")
    print(client)

    data = client.recv(BUFSIZE)
    print(data.decode("UTF-8"))

    client.sendall(msg.encode("UTF-8"))
    client.close()
#server0.pyの終わり


