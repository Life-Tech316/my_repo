#ifndef __Class_Counter
#define __Class_Counter

#include <climits>
#define UNIT_MAX 100

class Counter {
private:
  unsigned cnt;
public:
  Counter(): cnt(0) {}
  void increment(){
    if (cnt < UNIT_MAX) cnt++;
  }
  void decrement(){
    if (cnt > 0) cnt--;
  }
  unsigned value(){
    return cnt;
  }
};
#endif
