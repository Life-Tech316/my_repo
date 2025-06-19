//2重インクルードを防ぐ為のdef文
//他の名前でも良い
#ifndef Class_Date
#define Class_Date

#include <string>
#include <iostream>


//using namespace std; => ヘッダは使用できない

class Date {
  int y; //西暦
  int m; //月
  int d; //日

public:
  //デフォルトコンストラクタ
  Date();
  //コンストラクタの宣言
  Date(int yy, int mm = 1, int dd = 1);

  int year() const{  return y; } //年を返却
  int month() const{  return m; } //月を返却
  int day() const{  return d; } //日を返却
  //Date型を返却する関数の定義
  Date preceding_day() const; //前日の日付を返却

  std::string to_string() const;
};
std::ostream& operator<<(std::ostream& s, const Date& x); //挿入子

#endif
