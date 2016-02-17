#Úloha

#Popis

Trieda `TaskMaster` spravuje skupinu `Worker` vlákien. Každé `Worker` vlákno v nekonečnej slučke realizuje najprv nejakú prácu a potom zavolaním metódy `publishResult` publikuje výsledok. Pre správnu činnosť celej aplikácie je vyžadované, aby všetky vykonávania metódy `publishResult` ktoréhokoľvek vlákna v skupine jedného `TaskMaster`-a spĺňali podmienku vzájomného vylúčenia (t.j. iba jedno `Worker` vlákno publikuje výsledok - vykonáva metódu `publishResult`). Navyše vyžadujeme, aby výsledky boli publikované v zadanej postupnosti - najprv publikuje výsledky vlákno s ID rovným 0, potom vlákno s ID rovným 1, 2, 3, 4, 5, 0, 1, 2, ... táto postupnosť sa potom do nekonečna opakuje cyklicky. 
  
#Zadanie  

Upravte triedu `TaskMaster` a triedu `Worker` (rozšírením o vhodné sychronizačné objekty a/alebo kód), aby boli splnené všetky podmienky publikovania výsledkov. Pokúste sa navrhnúť čo "najjemnejšie" zamykanie a synchronizáciu tak, aby ste v maximálnej možnej miere eliminovali akýkoľvek "zbytočný" beh kódu (ak `Worker` nemôže pokračovať, nech je blokovaný).
