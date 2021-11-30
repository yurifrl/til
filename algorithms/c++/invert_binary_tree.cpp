#include <vector>
#include <iostream>

using namespace std;

class BinaryTree {
public:
  int value;
  BinaryTree *left;
  BinaryTree *right;

  BinaryTree(int value);
  void insert(vector<int> values, int i = 0);
  void invertedInsert(vector<int> values, int i = 0);
};

void invertBinaryTree(BinaryTree *tree) {
  //
}

int main() {
  BinaryTree *tree = new BinaryTree();

  tree->insert(10);
  tree->insert(6);
  tree->insert(14);
  tree->insert(5);
  tree->insert(8);
  tree->insert(11);
  tree->insert(18);

  std::cout << "hello";
}
