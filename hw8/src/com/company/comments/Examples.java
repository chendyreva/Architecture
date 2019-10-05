package com.company.comments;

public class Examples {
//bad example
// 1
    /* Replaces with spaces the braces in cases where braces in places cause stasis
    $str = str_replace(array("\{","\}")," ",$str);
    **/
 //2
//set the value of the age integer to 32
    int age = 32;

 //как должно быть
 //1
 /*
 * Replaces with spaces
 * the braces in cases
 * where braces in places
 * cause stasis.
 * //
    $str = str_replace(array("\{","\}")," ",$str);
   **/

 //2
  /*  function addSetEntry(set, value) {
 /*
  Don't return `set.add` because it's not chainable in IE 11.

        set.add(value);
        return set;
    }
  **/

// 3
  /**
//Dear maintainer:
//
//Once you are done trying to 'optimize' this routine,
//and have realized what a terrible mistake that was,
//please increment the following counter as a warning
//to the next guy:
//
//total_hours_wasted_here = 42
**/
}
