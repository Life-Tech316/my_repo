//日付クラスDate
#include <ctime>
#include <sstream>
#include <iostream>
#include "Date.h"

//名前空間の指定 std名前空間を使用する
using namespace std;

//Date型のデフォルトコンストラクタ
Date::Date()
{
  time_t current = time(NULL);
  struct tm* local = localtime(&current);

  //構造体のポインタ
  y = local->tm_year + 1900;
  m = local->tm_mon + 1;
  d = local->tm_mday ;
}

//Dateのコンストラクタ
Date::Date(int yy, int mm , int dd)
{
  y = yy;
  m = mm;
  d = dd;
}

//前日の日付を返却する関数
Date Date::preceding_day() const{
  //配列を定義
  int dmax[] = {31,28,31,30,31,30,31,31,30,30,30,31};
  Date temp = *this; //同一の日付

 if (temp.d > 1)
  temp.d--;
 else{
   if (--temp.m < 1){
     temp.y--;
     temp.m = 12;
   }
   temp.d = dmax[temp.m - 1];
 }
 return temp;
}

//文字列表現を返却
string Date::to_string() const
{
  ostringstream s;
  s << y << "年" << m << "月" << d << "日";
  return s.str();
}

//出力ストリームsにxを挿入
//Type型(ここでは　Date型の値を挿入子<<によって出力できるようにする)
ostream& operator<<(ostream& s,const Date& x)
{
  return s << x.year() << "年の" << x.month() << "月で" << x.day() << "日です\n" ;

}
