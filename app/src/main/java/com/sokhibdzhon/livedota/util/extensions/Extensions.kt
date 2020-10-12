package com.sokhibdzhon.livedota.util.extensions

import android.content.Context
import android.widget.Toast


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

fun Any?.runIfNull(block: () -> Unit) {
    if (this == null) block()
}

fun toast(context: Context, message: String) =
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()