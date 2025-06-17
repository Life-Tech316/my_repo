import os

import openai

openai.api_key = os.environ["OPENAI_API_KEY"]

response = openai.ChatCompletion.create(
    model="gpt-3.5-turbo",
    temperature=1,
    messages=[
        {"role":"user","content":"彼女に振られた時どうすればよいでしょうか?"}
    ],
    stream=False,
)

print(response.choices[0]["message"]["content"])
