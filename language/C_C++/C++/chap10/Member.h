//会員クラス　ヘッダ部
#include <string>

class Member {
//非公開
  std::string full_name; //氏名
  int   no;
  int   rank;
public:
  //コンストラクタ
  Member(std::string name,int number,int grade);
  //ランクの取得
  int get_rank() { return rank; }
  //ランクの設定
  void set_rank(int grade) { rank = grade; }
  //表示宣言
  boid print();
};











