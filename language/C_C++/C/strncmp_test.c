#include <stdio.h>
#include <string.h>

int main(void)
{
  char st[128];
  puts("「String」の先頭3文字と比較します");
  puts("「XXXX」で終了します");
  while (1){
    printf("文字列st : ");
    scanf("%s",st);
    if(strncmp("XXXX",st,3) == 0)
      break;
    printf("strncmp(「String」,st,3) = %d\n",strncmp("STRING",st,3));

  }
  return 0;
}
