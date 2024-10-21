# Play Playground

This is a Play Framework project built with Scala, demonstrating various features including a tax calculator and a dad joke generator.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Running application](#running-application)
- [Navigating the Application](#navigating-the-application)
- [Project Structure](#project-structure)
## Features

1. Tax Calculator: Calculate tax based on income input
2. Dad Joke Generator: Fetch and display random dad jokes

## Prerequisites

- Scala 2.13.14
- SBT 1.10.0
- Play Framework 3.0.4

## Running application

```
sbt run
```

## Navigating the Application

After starting the application, you can access the following features:

### Tax Calculator

1. Open your web browser and go to `http://localhost:9000/tax-calculator`
2. You will see a form where you can enter your annual income
3. Click the "Calculate Tax" button to see the calculated tax amount

### Dad Joke Generator

1. In your web browser, navigate to `http://localhost:9000/dadjoke`
2. You will see a random dad joke displayed on the page
3. Click the "Get New Joke" button to fetch and display a new joke

Note: Make sure the application is running before trying to access these pages.


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

