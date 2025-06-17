#include <math.h>
#include <stdio.h>

#define sqr(n) ((n) * (n))

//構造体を定義
typedef struct {
  double x; //X座標
  double y; //y座標
} Point;

//自動車を表す構造体
typedef struct {
  Point pt;  //現在位置
  double fuel; //残り燃料
} Car;

//関数定義
double distance_of(Point pa , Point pb)
{
  return sqrt(sqr(pa.x - pb.x) + sqr(pa.y - pb.y));
}

//燃料等の表示
void put_info(Car c)
{
  printf("現在位置  : (%.2f, %.2f)\n",c.pt.x, c.pt.y);
  printf("残りの燃料：　 %.2fリットル\n",c.fuel);
}

//cの指す車のの目的座標に移動
//構造体
int move(Car *c,Point dest)
{
  double d = distance_of(c->pt,dest);
  if (d > c->fuel)
      return 0;
  c->pt = dest;
  c->fuel -= d;
  return 1;
}

int main(void)
{
  //構造体の初期化 
  Car mycar ={{},90};  
  while(1){
    int select;
    Point dest;
    //車情報表示関数
    put_info(mycar);
    printf("移動しますか[Yes・・1/No・・0] : ");
    scanf("%d",&select);
    //break文の挿入
    if (select != 1) break;
    printf("目的地のX座標 : "); scanf("%lf",&dest.x);
    printf("目的地のY座標 : "); scanf("%lf",&dest.y);
    if (!move(&mycar,dest))
        puts("\a燃料不足で移動できません");
  }
  return 0;
}
