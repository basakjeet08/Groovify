package com.dev.androidmonkey.designsystem.molecular.textfield


/**
 * This class validates the different types of [AppTextFieldType]s which are there and it provides
 * implementation for validating the TextFields of all these types
 *
 * @param appTextFieldType This is the Type of the TextField according to which the validation would be
 * processed
 */
class AppTextFieldValidator(private val appTextFieldType: AppTextFieldType) {

    /**
     * This function checks if the inputted string by the User is valid or not
     *
     * @param input This is the inputted String by the User
     * @param isTyping This denotes if the user is typing or not
     */
    fun isInvalid(input: String, isTyping: Boolean): Boolean {
        if (!isTyping) return false

        return when (appTextFieldType) {
            is AppTextFieldType.None -> {
                false
            }

            is AppTextFieldType.Phone -> {
                input.length != 10
            }

            is AppTextFieldType.Mail -> {
                !android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches() &&
                        input.length < appTextFieldType.minStringSize ||
                        input.length > appTextFieldType.maxStringSize
            }

            is AppTextFieldType.Default -> {
                input.length < appTextFieldType.minStringSize || input.length > appTextFieldType.maxStringSize
            }

            is AppTextFieldType.Custom -> {
                appTextFieldType.isInvalidLogic.invoke(input, true)
            }
        }
    }


    /**
     * This function provides string values which would be given for the UI according to the
     * [AppTextFieldType] used
     *
     * @param input This is the Inputted string by the user
     */
    fun getErrorMessage(input: String): String {
        return when (appTextFieldType) {
            is AppTextFieldType.None -> {
                ""
            }

            is AppTextFieldType.Phone -> {
                "Enter a valid phone number"
            }

            is AppTextFieldType.Mail -> {
                if (input.isEmpty())
                    "E-mail can not be empty"
                else
                    "Enter a valid e-mail"
            }

            is AppTextFieldType.Default -> {
                "Text should be between ${appTextFieldType.minStringSize} - ${appTextFieldType.maxStringSize}"
            }

            is AppTextFieldType.Custom -> {
                appTextFieldType.getErrorMessageLogic.invoke(input, true)
            }
        }
    }

    /**
     * This is the function which provides the String to be shown in the Counter
     *
     * @param input this is the string inputted by the user
     */
    fun getStringCounter(input: String): String {
        return when (appTextFieldType) {
            is AppTextFieldType.None -> {
                ""
            }

            is AppTextFieldType.Custom -> {
                appTextFieldType.getStringCounterLogic.invoke(input)
            }

            else -> {
                "${input.length}/${appTextFieldType.maxStringSize}"
            }
        }
    }

    /**
     * This function provides if the text is valid or not for something
     */
    fun isTextValid(input: String): Boolean {
        return when (appTextFieldType) {
            is AppTextFieldType.None -> {
                false
            }

            is AppTextFieldType.Custom -> {
                appTextFieldType.isTextValidLogic.invoke(input)
                //input.length in appTextFieldType.minStringSize..appTextFieldType.maxStringSize
            }

            else -> {
                input.length in appTextFieldType.minStringSize..appTextFieldType.maxStringSize
            }
        }
    }
}