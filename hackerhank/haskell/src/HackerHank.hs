module HackerHank where

pureSolveMeFirst = show . sum . map read . words

solveMeFirst = interact $ show . sum . map read . words

simpleArraySum = interact $ show . sum . map read . tail .words

aVeryBigSum = interact $ show . sum . map read . tail .words
