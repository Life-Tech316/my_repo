# -*- coding: utf-8 -*-

#ソケットAPIモジュールのインポート
import socket

#接続先ホストの名前、ポート番号、受信バッファ
HOST="localhost"
#HOST="192.168.100.108"
PORT=50000
BUIFSIZE=4096

#メイン実行部
#ソケットの作成SOCK_DGRAMに着目
client = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
#サーバーとの接続
client.sendto(b"Hi!",(HOST,PORT))
#サーバからのメッセージ受信
data = client.recv(BUIFSIZE)
print(data.decode("UTF-8"))
#コネクションクローズ
client.close()
#client0.pyの終わり
