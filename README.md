# vmd_poker

this project implement by kotlin mvvm 

## Time Complecity x*n

Project structure 
- Model
  - Player
  - Card
  - Deck
- ViewModel
  - MainViewModel
- View
  - MainActivity

How to use
- build application
- to play game click new game button

Test Coverage
- Player
 - testComputeHandCard
- Card
 - getCardNameCorrectFormat
- Deck
 - initWithCorrectData
 - suffleCorrect
 - drawWorkCorrect
- MainViewModel
 - initCorrectly
 - dealoutCardCorrectly
 - checkStatusTieCase
 - checkStatusFirstPlayerWin
 - checkStatusSecondPlayerWin