# Play Playground

This is a Play Framework project built with Scala, demonstrating various features including a tax calculator and a dad joke generator.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)

## Features

1. Tax Calculator: Calculate tax based on income input
2. Dad Joke Generator: Fetch and display random dad jokes

## Prerequisites

- Scala 2.13.14
- SBT 1.10.0
- Play Framework 3.0.4

## Getting Started

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/play-playground.git
   cd play-playground
   ```

2. Install dependencies:
   ```
   sbt update
   ```

3. Run the application:
   ```
   sbt run
   ```

4. Open your browser and navigate to `http://localhost:9000`

## Project Structure

The project follows the standard Play Framework structure:

- `app/`: Application source code
  - `controllers/`: Controller classes
  - `models/`: Data models
  - `views/`: Twirl templates
  - `services/`: Business logic services
  - `connectors/`: External API connectors
- `conf/`: Configuration files
- `public/`: Static assets
- `test/`: Test files