#include <string>

//クラスの定義
class Account {
  std::string full_name;
  std::string number;
  long crnt_balance;
//public型のメソッド
public:
  Account(std::string name, std::string num,long amnt); //コンストラクタの定義

  std::string name() { return full_name;}
  std::string no() { return number;}
  long balance() { return crnt_balance;}

  void deposit (long amnt);
  void withdraw (long amnt);
};
