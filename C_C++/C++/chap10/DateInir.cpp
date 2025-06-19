#include <iostream>
#include "Date.h" //ヘッダの読み込み
//名前空間の宣言
using namespace std;

int main(){
  //コンストラクタ呼び出しによる初期化
  Date a(2015, 11,10);
  //同一型による初期化
  Date b = a;

  Date c = Date(2015, 11,10);

  cout << "a = " << a.year() << "年" << a.month() << "月" << a.day() << "日\n";
  cout << "b = " << b.year() << "年" << b.month() << "月" << b.day() << "日\n";
  cout << "c = " << c.year() << "年" << c.month() << "月" << c.day() << "日\n";

}
