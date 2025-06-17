#ライブラリopenaiをよみこみ
import openai
import os
#OpenAIのAPIキーを設�?
openai.api_key = os.environ["OPENAI_API_KEY"]


def make_tweet():
    #GPTに対する命令文
    request = "私はIT社員。'\
    この文章はTwitter APIとgpt3.5のAPIをしようして、生成AIがTwitterに投稿している。その旨を投稿文を100文字以内で作成してください"
    tweet1 = "試しにpythonとgptのAPIを使用して作成。プログラミングは楽しい"

    #文章を連結
    content = request + tweet1

    #chatgptにリクエスト
    response = openai.ChatCompletion.create(
        model = "gpt-3.5-turbo",
        messages = [
            {"role":"user","content":content}
        ],
    )

    return response.choices[0]["message"]["content"]
