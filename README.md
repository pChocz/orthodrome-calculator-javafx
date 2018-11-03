# Orthodrome Calculator

Calculator for the orthodrome (great circle) and loxodrome parameters for navigation purposes.

Orthodrome is a part of the great circle that crosses any pair of the points on the sphere.
Through any two points on a sphere (that are not directly opposite each other), there is 
a unique great circle. The length of the shorter arc of such great circle is so called
great-circle distance (or orthodromic distance) and is the shortest path between two 
points on the surface of the sphere.

In case of antipodal points (directly opposite to each other) there exist infinitely many
great circles. For such cases there are also infinitely many shortest paths, as each one
will be equal to the half of the sphere circumference.

## Getting Started

```Orthodrome Calculator``` can be used in order to calculate several orthodrome/loxodrome 
parameters for the navigation purposes:
* All angles (ABC) and sides (abd) of the spherical triangle created from 2 given points and 
the North Pole,
* Orthodrome distance (in angle units as well as Nm/km),
* Orthodrome bearing angles (initial and final, in angle units),
* Orthodrome vertices,
* Loxodrome distance,
* Orthodromic gain.

Application calculates above parameters for the following types of cases:

`Meridian Sail Case` - 
If both points lie on the same meridian, the orthodrome contains this meridian as well.
In such case the spherical triangle does not exist, but the calculation is simplified.
Sail direction in this case is either straight `N` or straight `S`.

`Equator Sail Case` - 
If both points lie on the equator, the orthodrome will lie on the equator as well.
In such case calculation is simplified, as the spherical triangle has two
right angles. Sail direction in this case is either straight `E` or straight `W`.

`Antipodal points` - 
If points are directly opposite to each other, inifinitely many orthodromes exist.
In such case application sets the initial bearing angle as `free to choose` and
final bearing angle as `180° - α`.

`General Case` -
If points do not meet any of above conditions, general case algorithm is applied.
In such case all the parameters are calculated normally.



### Installing & Using

Simply download the most recent executable [jar file](orthodrome-calculator_newest.jar)
and run it from your computer. Languages available to choose within the application 
are `EN` and `PL`.

#### Input format

You need to specify co-ordinates of two points in following format:

`Angle`° `Minute`' `Side`

Each point consists of two co-ordinates: latitude and longitude.
* `Angle` value must be integers between:
  * `0` and `90` for latitude
  * `0` and `180` for longitude
* `Minute` value must be doubles between `0.0` and `59.9`
* `Side` value must be:
  * either `N` or `S` for latitude
  * either `E` or `W` for longitude


## Contributing

If you spot any issue or have an idea how to improve the project please contact me via my 
GitHub account.

## License

This project is licensed under the MIT License, therefore it's free to use and modify - see 
the [LICENSE](LICENSE) file for details.

## Acknowledgments

* Inspiration
* etc




