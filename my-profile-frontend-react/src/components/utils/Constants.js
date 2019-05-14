export const BASE_URL = "http://localhost:8082/userapi/";
export const BASE_USER_URL = BASE_URL + "users/";
export const VARIANT_PRIMARY = "primary";
export const VARIANT_SECONDARY = "secondary";
export const VARIANT_SUCCESS = "success";
export const VARIANT_DANGER = "danger";
export const VARIANT_WARNING = "warning";
export const VARIANT_INFO = "info";
export const VARIANT_DARK = "dark";
export const VARIANT_LIGHT = "light";
export const VARIANT_LIST = [
    VARIANT_PRIMARY,
    VARIANT_SECONDARY,
    VARIANT_SUCCESS,
    VARIANT_DANGER,
    VARIANT_WARNING,
    VARIANT_INFO,
    VARIANT_DARK,
    VARIANT_LIGHT
 ];


function generateRandVariant() {
    return VARIANT_LIST[Math.floor(Math.random()*VARIANT_LIST.length)];
}
export function generateRandColors() {
    const randVariant = generateRandVariant();
    if(randVariant === VARIANT_LIGHT) {
        return {
            bgColor: randVariant,
            textColor: VARIANT_DARK,
            borderColor: generateRandVariant()
        }
    } else {
        return {
            bgColor: randVariant,
            textColor: VARIANT_LIGHT,
            borderColor: generateRandVariant()
        }
    }
}