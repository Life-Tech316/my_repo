//スタック本体
#include <stdio.h>
#include <stdlib.h>
#include "IntStack.h"

//スタックの初期化

int Initialize(IntStack *s,int max)
{
    s->ptr = 0;
    //配列の確保に失敗(callocによるメモリの確保)
    //解放したメモリのアドレスをポインタに指している
    if((s->stk = calloc(max,sizeof(int))) == NULL){
        s->max = 0;
        return -1;
    }
    s->max = max;
    return 0;
}

int Push(IntStack *s,int x)
{
  if (s->ptr >= s->max)
      return -1;
  //*pのp[i]は、ポインタの中身を指している
  s->stk[s->ptr++] = x;
  return 0;
}

int Pop(IntStack *s,int *x)
{
    if(s->ptr <=0)
      return -1;
    //以前の値が代入されたアドレスが渡され、それがポインタで操作される
    //一つ前のポインタ(s->stk[--s->ptr])の内容がxに代入される
    //xを表示すると(s->stk[--s->ptr]の値が表示される

    *x = s->stk[--s->ptr];
    return 0;
}

int Peek (const IntStack *s,int *x)
{
  if (s->ptr <= 0)
    return -1;
  *x = s->stk[s->ptr - 1 ];
  return 0;
}

void Clear(IntStack *s){
  s->ptr=0;
}

int Capacity(const IntStack *s){
  return s->max;
}

int Size(const IntStack *s){
  return s->ptr;
}

int IsEpty(const IntStack *s)
{
  return s->ptr <= 0;
}

int IsFull(const IntStack *s)
{
  return s->ptr >= s->max;
}

int Search(const IntStack *s, int x)
{
  int i;
  for (i = s->ptr -1; i >= 0; i--)
    if(s->stk[i] == x)
      return i;
  return -1;
}
//constは、変数の書き換え禁止
void Print(const IntStack *s)
{
  int i;
  for (i = 0; i < s->ptr; i++)
    printf("%d ",s->stk[i]);
  putchar('\n');
}

void Terminate(IntStack *s)
{
  if (s->stk != NULL )
    free(s->stk);
  s->max = s->ptr = 0;
}
