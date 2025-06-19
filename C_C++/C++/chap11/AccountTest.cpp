#include <iostream>
#include "Date.h"
#include "Account.h"

using namespace std;

int main()
{
	//コンストラクタによるアカウントの初期化
	Account suzuki("鈴木隆一","12345678",1000,Date(2125,1,24));
	//コンストラクタによるアカウントの初期化ß
	Account takeda("武田浩史","87654321",200,Date(2125,1,24));

	Date date(1993,3,16);
	cout << date;

	suzuki.withdraw(200); //クラス関数の実行
	takeda.deposit(100); //クラス関数の実行

	cout << "鈴木くんの口座\n";
	cout << "名義指名 = " << suzuki.name() << '\n';
	cout << "口座番号 = " << suzuki.no() << '\n';
	cout << "預金残高 = " << suzuki.balance() << "円\n";
	cout << "開設日 = " << suzuki.opening_date() << '\n';

	cout << "\n武田くんの口座\n";
	cout << "名義指名 = " << takeda.name() << '\n';
	cout << "口座番号 = " << takeda.no() << '\n';
	cout << "預金残高 = " << takeda.balance() << "円\n";
	cout << "開設日 = " << takeda.opening_date().year() << "年"
											<< takeda.opening_date().month() << "月"
											<< takeda.opening_date().day() << "日\n";
}
