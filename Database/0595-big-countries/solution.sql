select name,population,world.area
from world
where world.area >= 3000000 or population >= 25000000
