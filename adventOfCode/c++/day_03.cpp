#include <cstring>
#include <fstream>
#include <iostream>
#include <string>
#include <vector>
using namespace std;

void sample() {
  ifstream infile;
  int count = 0, x = 0, y = 0, right = 3, down = 1, rows, cols;
  string input;
  vector<string> forest;

  infile.open("../data/day_03.txt");

  while (getline(infile, input))
    forest.push_back(input);

  rows = forest.size();
  cols = forest[0].size();

  cout << count << endl;
  for (int i = 0; i < rows; i++) {
    std::copy(forest.begin(), forest.end(), std::ostream_iterator<string>(std::cout, " "));

    if (forest[x][y] == '#')
      ++count;
    x += down;
    y = (y + right) % cols;
  }
}

int main() {
  //
  sample();
}
