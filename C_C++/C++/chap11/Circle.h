#ifndef __Circle
#define __Circle
#include "Point2D.h"

//円クラス
class Circle{
  //2次元クラス
  Point2D center;
  //半径
  int radius;
public:
  /*関数の渡しの種類
  　・値渡し (変数のコピー)
  　・参照渡し（ポインタを使わずにエイリアス作成、今回のように&をつける）
    ・ポインタの値渡し(ポインタを使った変数の受け渡し)
  ・*/
  Circle(const Point2D& c, int r) : center(c),radius(r){}
  //初期化
  Point2D get_center() const {return center;}
  int get_radius() const {return radius;}
  void print() const{
    std::cout << "半径[" << radius << "] 中心座標"; center.print();
  }
};
#endif
