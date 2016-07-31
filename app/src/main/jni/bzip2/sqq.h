//
// Created by Administrator on 2016/7/27.
//

#ifndef UPDATEAPK_SQQ_H
#define UPDATEAPK_SQQ_H

#ifdef _WIN32
#   include <windows.h>
#   ifdef small
      /* windows.h define small to char */
#      undef small
#   endif
#   ifdef BZ_EXPORT
#   define BZ_API(func) WINAPI func
#   define BZ_EXTERN extern
#   else
   /* import windows dll dynamically */
#   define BZ_API(func) (WINAPI * func)
#   define BZ_EXTERN
#   endif
#else
#   define BZ_API(func) func
#   define BZ_EXTERN extern
#endif

BZ_EXTERN int BZ_API(compare) (
        int       a,
        int       b
);

#endif //UPDATEAPK_SQQ_H
