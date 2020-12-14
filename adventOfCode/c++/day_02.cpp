#include <iostream>
#include <string>

class Input {
  public:
    int lowContranit;
    int topContranit;
    char constraint;
    std::string word;
    Input( int a, int b, char c, std::string d) {
			lowContranit = a;
			topContranit = b;
      constraint = c;
      word = d;
		}
    bool isValid() {
      int count = 0;
      for (int i = 0; i< word.length(); i++) {
        if (word[i] == constraint) {
          count++;
        }
        if (count > topContranit) return false;
      } 
      if (count < lowContranit) return false;
      return true;
		}
};


int main() {
  const int input_size = 3;
  bool inputs[input_size] = {
    Input (1 , 3, 'a', "abcde").isValid(),
    Input (1 , 3, 'b', "cdefg").isValid(),
    Input (2 , 9, 'c', "ccccccccc").isValid(),
  };



  int result = 0;
  for (int i; i < input_size; i++) {
    if (inputs[i] == false) result++;
  }

  std::cout << "Result 01: " << result << std::endl;
}
