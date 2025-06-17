import os
import win32com.client

# Outlookアプリケーションを開始
outlook = win32com.client.Dispatch("Outlook.Application").GetNamespace("MAPI")

# 受信トレイにアクセス
inbox = outlook.GetDefaultFolder(6)  # 6 は受信トレイを指します


# フォルダ内の全アイテムを取得
messages = inbox.Items

# フィルタリング条件（例: 特定の送信者）
sender_email = "ai-ito\@jac-recruitment.jp"
download_folder = "C:\\Users\\nishi\\iCloudDrive\\仕事関連\\経歴内容\\test"

# メールのチェックと添付ファイルのダウンロード
for message in messages:
    print(f"Checking message from: {message.SenderEmailAddress}")  # メールの送信者を出力

    if message.SenderEmailAddress == sender_email:
        print(f"Found message: {message.Subject}")  # 対象メールの件名を出力
        attachments = message.Attachments

        if attachments.Count == 0:
            print("No attachments found in this message.")
        else:
            for attachment in attachments:
                attachment_path = os.path.join(download_folder, attachment.FileName)
                print(f"Saving attachment: {attachment.FileName} to {attachment_path}")
                attachment.SaveAsFile(attachment_path)
        
        print(f"Attachments from {message.Subject} saved.")
    else:
        print("No matching sender found.")
