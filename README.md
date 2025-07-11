# 👽 compAlien Genetics Simulation 
> 🗓️ Created during my **Freshman Year** of university.

## 🎯 Objective

To simulate the lifecycle and genetic behavior of an alien species named **compAlien** using Java. Each individual in the population has a genetic code composed of the characters `C`, `S`, and `E`, and exhibits specific traits based on their genetic structure.

---

## 🧬 Genetic Details

- Each compAlien has a genetic code with **128 characters**, composed of `'C'`, `'S'`, `'E'`.
- **Health**: Based on the number of distinct `"CSE"` sequences.
- **Gender**:
  - If the 128th character is `'S'`: **Male**
  - If the 128th character is `'C'` or `'E'`: **Female**
- **Reproduction**:
  - Allowed only between opposite genders.
  - Probability of reproduction:  
    `p = (Health_X + Health_Y) / N`  
    (Tune N accordingly to ensure probability is between 0 and 1.)

---

## 🧪 Simulation Features

- Ask user for initial population size
- Randomly generate compAliens with genetic codes
- Calculate gender and health for each
- Assign unique IDs
- Present interactive menu:

### 🔘 Menu Options

1. **Mate two compAliens**  
   Enter IDs → check genders → simulate mating → show result

2. **Randomly mate a set**  
   Enter number of pairs → simulate all

3. **Show statistics**  
   - Female/Male distribution
   - Number of compAliens with health ≥ threshold
   - Add your own creative stats

4. **Find friends with the same-sex**  
5. **Capability of Military Service**  

---

## 💻 Sample Output

```
Enter the size of compAlien population: 71
Simulating compAlien species…
——————————————————————————--
ID:1, Female, Health: 4
ID:2, Female, Health: 1
ID:3, Male, Health: 3
...
ID:71, Male, Health: 8
——————————————————————————--
compAlien population is generated!

Choose an options:
(1)Mate two compAliens
(2)Randomly mate a set of compAliens
(3)Show statistics
(4)Your other option-1
(5)Your other option-2
Enter an option: 1

Mating two compAliens
————————————————————-
Enter ID of first compAlien: 13
Enter ID of second compAlien: 32
compAlien 13(M) and 32(F) Mate: Offspring chance 67%. They have 1 offspring :)
```

