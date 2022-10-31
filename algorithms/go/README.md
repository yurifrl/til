
# Find middle by bity shifting
This two do the same thing, the second one does by byte shifting

eg: https://cs.opensource.google/go/go/+/refs/tags/go1.19.2:src/sort/search.go;l=63

```golang
mid = left + (right - left) / 2
mid = int(uint(right + left))>>1
```
