#include <iostream>
#include "Date.h"

using namespace std;

int main()
{
  const Date birthday(1963,11,18); //constオブジェクト
  Date day[3];

  cout << "birthday = " << birthday << '\n';
  cout << "birthdayの文字列表現 ：\" " << birthday.to_string() << "\"\n";

  for (int i = 0; i < 3; i++){
    cout << "day[" << i << "]の文字列 :\"" << day[i].to_string() << "\"\n";
  }
}
