#include <stdio.h>
#include "IntStack.h"

int main(void)
{
  IntStack s;
  if (Initialize(&s,64) == -1){
    puts("スタックの生成に失敗しました");
    return 1;
  }
  while(1){
    int menu, x;
    printf("現在のデータ数 : %d / %d\n",Size(&s),Capacity(&s));
    printf("(1)プッシュ (2)ポップ　(3)ピーク (4)表示　(5)終了 :  ");
    scanf("%d",&menu);

    if(menu == 0) break;

    switch(menu){
      case 1:
        printf("データ : ");
        scanf("%d",&x);
        if (Push(&s,x) == -1)
          puts("プッシュに失敗しました。");
        break;
      case 2:
        if (Pop(&s,&x) == -1)
          puts("ポップに失敗しました。");
        else
          printf("ポップしたデータは%dです。\n",x);
        break;
      case 3:
        if (Peek(&s,&x) == -1)
          puts("ピークに失敗しました。");
        else
          printf("ピークしたデータは%dです。\n",x);
        break;
      case 4:
        Print(&s);
        break;
    }

  }
  Terminate(&s);
  return 0;
}
