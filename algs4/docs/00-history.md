# Timeline
- migrated from mvn to gradle

# Remember
- C-a + s
- Nerdtres: Shift + R
- Repl:
    - docker run --rm -it passy/java-repl
    - docker run --rm -it parana/java-jdk9 jshell
- get data `wget http://algs4.cs.princeton.edu/code/algs4-data.zip`
- Add jar to docker:
    - http://stackoverflow.com/questions/39100884/unable-to-provide-classpath-in-docker
    - http://stackoverflow.com/questions/37466511/how-to-build-dockerfile-with-two-jar-files
    - https://hub.docker.com/r/iris/playground/~/dockerfile/
- docker-compose -f docker-compose.package.yml run --rm web java-algs4 edu.princeton.cs.algs4.RandomSeq 1000 100.0 200.0
- docker-compose -f docker-compose.package.yml run --rm web bash
- cd /usr/local/algs4/algs4-data
- java-algs4 edu.princeton.cs.algs4.BinarySearch largeW.txt < largeT.txt

# Tolls
- Algorithms web tools:
    - http://algo-visualizer.jasonpark.me
- Repl web tools:
    - https://repl.it/languages/java
    - http://www.javarepl.com/term.html
- Docker repl Tools:
    - http://joao-parana.com.br/blog/java-9-no-docker-java-playground-com-repl/
    - https://github.com/passy/java-repl
    - https://github.com/albertlatacz/java-repl

# Code snipets (i don't remenber java)
```
  public void testMainCall() {
    App.main(new String[] {  });
  }

  public void testSqrt() {
    App obj = new App();
    assertTrue( obj.sqrt(4) == 2  );
  }

  public static void main( String[] args ) {
    System.out.println("Hello from main");
  }
```
