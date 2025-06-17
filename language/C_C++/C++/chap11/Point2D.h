#ifndef __Point2D
#define __Point2D

//クラス定義
class Point2D{
  int xp,yp;
public:
  //初期化
  Point2D(int x = 0,int y = 0) : xp(x),yp(y){}
  int x() const{return xp;}
  int y() const{return yp;}
  void print()const{std::cout << "(" << xp <<"," << yp << ")";} //表示
};

#endif
