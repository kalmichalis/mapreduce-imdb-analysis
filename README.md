# MapReduce IMDB Analysis

MapReduce algorithms for IMDB movie dataset analysis by country and genre in Java.

## Components
- **IMDBMapReduceLocal** - Main class, orchestrates the MapReduce jobs
- **RuntimeByCountryMapper** - Maps movies to countries with their duration
- **RuntimeByCountryReducer** - Reduces to total runtime per country
- **MoviesByYearGenreMapper** - Maps movies to year-genre pairs with score filtering
- **MoviesByYearGenreReducer** - Reduces to total movies per year and genre

## Features
- Calculates total movie runtime per country
- Counts movies per year and genre with score greater than 8
- Handles co-productions (runtime counted for all countries)
- Ignores malformed data lines

## How to Run

Compile with NetBeans or:
ant build
Run:
ant run

## Input
- `movies.csv` - IMDB dataset with movie metadata

## Technologies
Java, MapReduce, NetBeans, Ant
