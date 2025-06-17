# -*- coding: utf-8 -*-


#ソケットAPIモジュールのインポート
import socket

#グローバル変数
#ポート番号変数

PORT = 50000

#メイン実行部
#ソケットの作成
server = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
#アドレス設定
server.bind(("",PORT))
#サーバーの待ち受け
server.listen()
#クラインへの対応処理
client,addr=server.accept()
client.sendall(b"HI,nice to meet you!\n")
client.close()
server.close()
#server0.pyの終わり


