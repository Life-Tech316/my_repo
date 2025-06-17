# -*- coding: utf-8 -*-

#ソケットAPIモジュールのインポート
import socket

while True:
    try:
        hostname = input("ホスト名を入力(qで終了)")
        if hostname == "q": #終了
            break
        print(socket.gethostbyname(hostname))
    except:
        print("変換できませんでした")
# gethostbyname.pyの終わり

