//自動車クラスの指定
#include <iostream>
#include "Car.h"

using namespace std;

//メイン関数
int main()
{
  //名前の定義
  string name;
  //その他変数の定義
  int width,length,height;
  double gas;
  //出力変数の定義
  cout << "車のデータを入力せよ \n";
  cout << "名前は : "; cin >> name;
  cout << "車幅は : "; cin >> width;
  cout << "車長は : "; cin >> length;
  cout << "車高は : "; cin >> height;
  cout << "ガソリン量は : "; cin >> gas;

  //オブジェクトの実体生成
  Car myCar(name, width, length,height,gas); //クラスの生成

  myCar.print_spec(); // スペック表示

  //本体PGMロジック箇所
  //以下のロジックの繰り返し
  while (true){
    cout << "現在地" << myCar.x() << " , " << myCar.y() << "\n";
    cout << "残り燃料" << myCar.fuel() << "\n";
    cout << "移動[0・・NO / 1・・Yes] : ";
    int move;
    cin >> move;
    //プログラムの消費
    if (move == 0 ) break;
    double dx,dy;
    cout << "X方向の移動距離 : "; cin >> dx;
    cout << "Y方向の移動距離 : "; cin >> dy;
    if (!myCar.move(dx,dy))
        cout << "燃料が足りません\n";
  }
}
