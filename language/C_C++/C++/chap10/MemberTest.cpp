//会員クラスの利用ソースコード

#include <iostream>
#include <Member.h>

sing namespace std;

void print (Member *p)
{
p->printf();
}
int main(){
  Member kaneko("金子検事",15,4);
  kaneko.set_rank(kaneko.get_rank() + 1);
  print(&kaneko);
}
