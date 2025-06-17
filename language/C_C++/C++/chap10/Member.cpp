//会員クラス　（ソース部）

#include <iostream>
#include "Member.h"

using namespace std;

//コンストラクタ定義
Member::Member(string name, int number , int grade)
{
  full_name = name; no = number; rank = grade;
}

//表示「定義」
void Member::print()
{
  cout << "No." << no << ":" << full_name << "[ランク：" << rank << "] \n"; 
}









