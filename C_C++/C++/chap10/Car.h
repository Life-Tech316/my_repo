//自動車クラスの定義

#include  <cmath>
#include  <string>
#include  <iostream>

//クラス本体
class Car{
  std::string name;       //名前
  int width,length,height;//車幅等
  double xp,yp;           //現在位置座標
  double fuel_level;      //残り残量

//メンバー
public:
//コンストラクタ
  Car(std::string n, int w , int l, int h,double f){
    name = n; width = w , length = l, height = h,fuel_level = f;
    xp = yp = 0.0;
  }
  //以下メンバ関数(メソッド)の定義(インライン関数)
  double x() { return xp; }
  double y() { return yp; }
  double fuel() {return fuel_level; }
  void print_spec(){
      std::cout << "名前 : " << name << "\n";
      std::cout << "車幅 : " << width << "mm\n";
      std::cout << "車長 : " << length << "mm\n";
      std::cout << "車高 : " << height << "mm\n";
    }
  //移動関数
  bool move(double dx, double dy){
    //移動距離
    double dist = sqrt(dx* dx + dy * dy);
    if (dist > fuel_level)
      return false;
    else {
      //移動距離分だけ燃料が減る
      fuel_level -= dist;
      xp += dx;
      yp += dy;

      return true;
    }
  }
};
