# Shooting Game

## Introduction of this project

This is a shooting game. This shooting game includes one player, one boss, and some ghosts. The conception of this game refer  [Cuphead](https://store.steampowered.com/app/268910/Cuphead/).</br>
Such, the main character is Cuphead. The fianl goal for Cuphead is to defeat the boss. However, the boss' health point won't reveal on the monitor.</br>
Besides defeating the boss, Cuphead only has three lives. Be careful from being death. Cuphead's HP will decrease when Cuphead runs into the boss or ghosts. When Cuphead drops out of the window, the life quantities will also deacrease.</br>
Using PNG file and threading to complete the moves.</br>

LINK: [Raw Code](Cuphead/)

Row | Context
-----|--------
 Project Name |  Shooting Game
 Group Size |  1
 Using Programing Language | Java


## Game Desinging
### Cuphead
![image](https://user-images.githubusercontent.com/47874829/131774810-dc20c771-726d-40bb-9bf8-ec2efd3e27b6.png)</br>
Ability:</br>
1. Cuphead is able to stand on wind.</br>
2. Cuphead can jump twice without standing on wind.</br>
3. Cuphead has three lives.</br>
4. It can fire bullets to the boss and ghosts.</br>
5. Decreasing life while Cuphead runs into ghosts or the boss.</br>
6. Decreasing life while Cuphead drops out of the window.</br>

Manipulate instuction:</br>
1. UP: jump</br>
2. RIGHT: move to the right</br>
3. LEFT:move to the left</br>
4. Crtl+RIGHT: fire a horizontal bullet</br>
5. Crtl+UP: fire a oblique above bullet</br>
6. Crtl+DOWN: fire a oblique below bullet</br>
</br>

![image](https://user-images.githubusercontent.com/47874829/131775614-faa27ea0-3bfb-45a2-8602-50a8b88eb3a3.png)

</br>

![image](https://user-images.githubusercontent.com/47874829/131775632-2c038afd-770c-48e2-b356-53990e6dccb2.png)

</br>
</br>

![image](https://user-images.githubusercontent.com/47874829/131775648-532052a2-62fc-449a-bbbb-ba2bcd735584.png)

</br>
</br>

### Boss
![boss](https://user-images.githubusercontent.com/47874829/131776115-7b237d95-d89c-4f9b-ad8c-a29d9e0719ef.png)
</br>
Ability:</br>
1. 1000 drops of blood.</br>
2. Dropping one blood while Boss hurt by one bullet.</br>

### Ghost
![ghost](https://user-images.githubusercontent.com/47874829/131776074-d13521e3-7fb4-4082-8604-1891ce3ff030.png)</br>
Ability:</br>
1. Die when it hurt by one bullet.</br>

![image](https://user-images.githubusercontent.com/47874829/131776468-add88732-30c1-41bf-a7af-7c8378290433.png)
</br>


## Difficulties
1. Can't complete an animation in one thread. This animation will occupy the program performance at the same timeline.</br>
