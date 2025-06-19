//日付クラス
//ヘッダ部
class Date{
  int y;
  int m;
  int d;
public:
  Date(int yy, int mm,int dd);//コンストラクタ
  int year() { return y; }
  int month() { return m; }
  int day() { return d; }
};

