#include <fstream>
#include <iostream>
using namespace std;

class Input {
public:
  int lowContranit;
  int topContranit;
  char constraint;
  string word;
  Input(int a, int b, char c, std::string d) {
    lowContranit = a;
    topContranit = b;
    constraint = c;
    word = d;
  }
  bool isValid() {
    int count = 0;
    for (int i = 0; i < word.length(); i++) {
      if (word[i] == constraint) {
        count++;
      }
      if (count > topContranit)
        return false;
    }
    if (count < lowContranit)
      return false;
    return true;
  }
  bool isTwoValid() {
    if (word[lowContranit] == constraint && word[topContranit] == constraint) { return false; };
    return word[lowContranit] == constraint|| word[topContranit] == constraint;
  }
};

void sample() {
  int result = 0;
  const int input_size = 3;
  bool inputs[input_size] = {
      Input(1, 3, 'a', "abcde").isValid(),
      Input(1, 3, 'b', "cdefg").isValid(),
      Input(2, 9, 'c', "ccccccccc").isValid(),
  };

  for (int i; i < input_size; i++) {
    if (inputs[i])
      result++;
  }

  std::cout << "sample 01: " << result << std::endl;
}

void exer_01() {
  int result = 0;

  ifstream infile;
  string input;
  infile.open("../data/day_02.txt");

  while (getline(infile, input)) {
    char w[100];
    Input i(0, 0, 0, "");
    sscanf(input.c_str(), "%d-%d %c: %s", &i.lowContranit, &i.topContranit,
           &i.constraint, w);
    i.word.append(w);

    if (i.isValid())
      result++;
  }

  std::cout << "Result 01: " << result << std::endl;
}

void exer_02() {
  int result = 0;

  ifstream infile;
  string input;
  char constraint;
  int min, max;
  char w[100];
  infile.open("../data/day_02.txt");

  while (getline(infile, input)) {
    sscanf(input.c_str(), "%d-%d %c: %s", &min, &max, &constraint, w);

    Input i(min - 1, max - 1, constraint, string(w));

    if (i.isTwoValid())
      result++;
  }

  std::cout << "Result 02: " << result << std::endl;
}

int main() {
  sample();
  exer_01();
  exer_02();
}
