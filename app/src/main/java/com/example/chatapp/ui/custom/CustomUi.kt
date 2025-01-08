package com.example.chatapp.ui.custom

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.chatapp.ui.theme.HintTextColor
import com.example.chatapp.ui.theme.NormalOutlineTextColor
import com.example.chatapp.ui.theme.TextButtonColor

@Composable
fun CustomTextButton(
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    TextButton(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 24.dp)
            .height(50.dp),
        onClick = onClick,
        content = {
            Text(
                text,
                color = TextButtonColor,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
            )
        },
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.White
        ),
        enabled = enabled
    )
}

@Composable
fun CustomOutlineTextField(
    modifier: Modifier = Modifier,
    textDefault: String = "",
    label: String = ""
) {
    var text by remember { mutableStateOf(textDefault) }
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = NormalOutlineTextColor,
            unfocusedBorderColor = NormalOutlineTextColor,
            errorBorderColor = NormalOutlineTextColor,
            disabledBorderColor = NormalOutlineTextColor,
        ),
        textStyle = MaterialTheme.typography.bodyMedium,
        singleLine = true,
        onValueChange = {
            text = it
        },
        label = {
            Text(
                label,
                color = HintTextColor,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
            )
        },
        value = text
    )
}