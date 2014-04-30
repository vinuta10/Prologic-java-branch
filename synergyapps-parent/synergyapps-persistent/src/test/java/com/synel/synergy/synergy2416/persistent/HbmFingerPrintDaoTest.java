package com.synel.synergy.synergy2416.persistent;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.synel.synergy.synergy2416.webservices.SynergyWebServices;
import com.xacttime.Fingerprint;

public class HbmFingerPrintDaoTest {
	private SynergyWebServices mSws;
	private List<Fingerprint> mFps;
	private int uId;
	private String fpsample = "ZQAAAAABASYAAAAAAAAAAAAAAAAAAAAAFVVUAABqqqQAAD//9AAAv//5AAH///kAAf//+AAB//P8AAH/4fQAAf//9AAB/8PwAAG/0/AAAG//0AAAVqqAAABFVQAAAAAAAAAAAAAAAAAAAAAAEBD7+/sM+/v7+/v/+/v7EPsQ+/v7+xD7+/sQ+wAQ/Pv7EPv7EBD7Bvv7+/v7DvsQEPsA+/v8+/0Q+/v/EBAQ+/78/QD7+/sPEPsQ+/v7+/z7DPv7+/z8CPv7+/v7+xD7+xD7EPv7EP/7+/v7+xD7EPsQEPz7+/sO+/v7+/v7EPv7+/z7+/v7EPsQ+/v7+wEQEPsB+wD8+wz7+/v7BPv9+/v7/hACEPz7+/v7+/z7+wgC+wgQ+/wE+/v7EPsQ+/v7+/v8+/v7+xAJOyf08OTg4eDk8PQnOwkAlAAgABljAwMDBhIF9AQY5w34DPv7E1T8uAA0AD5IAgMC5AsM7vsJ6u/3JhAKFkcdwgBHABsAAwMD8Q7gERPkBQ32LgXpPjH4wQBYAD8WAwMDCPT1FhMG/gH0BQs4DkMNzABbAD8WAgMC9fMMAhEO6BffEhknA00PpQBfADulAwMD8BkE3Pny8vYFJQEQHkUW0wB2AEWHAgICCgPo6hb3ADLX/dwA6TfakAB1ABdKAwMDAAP59PjzBQHxFe48EB0r2wCSACnHAgIC7Pn2Awn68+UY9QwB5y4agABzABsBAgMC9e77+wEDDxDwJfwVAg1PwACOACuQAwMD4OgMGw7tAvsYAP4I8x0awgCcAC+QAwMD5f8G8wAB9u0D/uws8CkQrgCZAC9hAwMDBg7o5vsR99vkEAwrwgvdqACiADMRAwMDDvAA9vMQAe8FAwVV9i7/kQCWADMkAgMC8BPlygbf9Pf1Fdki7REGYwCFACkwAwMD2RD63P/88e4YDvoJ6RY6bAC4AA8lAwMDA+35/Q4Q+voIF/kOPjPgVQCSAAcPAwMD5vgH8Abm5vDpCfzoEi/bUACoAC2JAwMD7PL68AzuE/LrIgMOGxw2RQCSAAVeAwMDDPPt/wYEAAUSIPwGLTDKNwBdAB+6AwMD5xIF6f0FCP3jLv8dKiUuSAA9AD9mAwMD/P/z/wwY8QEKJPoXPzbqWABjAB0dAwMD7gIDy/IEAgz4JPUbEx45GwBJAEMlAgIB9Pz4+hT49OsIHPcCSTDknACYADNvAgMCBiTo0wDz8AADGuE0ACHsYwCXAC0BAgMCAPUD5/4T9fr6HvIQ/g43DACXAAMAAQEAAAAAAAAAAAAAAAAAAAAAFABjACEhAQEB8QQA3QsPAvzuGQgZNCobmwCBABFhAQMB9v33APkVE+TqEiQnu+bktQBvAD8+AQMBDOL2DQ4cFQfnBDok0Tr6xwChAC+QAQMB9f31/fgF/Q4eBd40ARcLaACZAC2JAQMB++v19xH4A/sGHvQW9xg8uwCeAC+8AQMB3eoL5fglCObiAPA40RzmzQA7AD+PAQIB8xvw6QD4/PwQIBPvFkUX2wCdACmzAQIB1+YFGBD58/gL9wUN7S0i4ABGAEE8AQEB9AwD7fv3+AD+JQ4XFU4Z7wBXAEN+AQEBAP83AgoP2vzd6fkZC1X49AB3AEc4AQEBBSPl6g3x8/T699fzCUn4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
/*
 * UID: 2 Template: ZQAAAAABASYAAAAAAAAAAAAAAAAAAAAAFVVUAABqqqQAAD//9AAAv//5AAH///kAAf//+AAB//P8AAH/4fQAAf//9AAB/8PwAAG/0/AAAG//0AAAVqqAAABFVQAAAAAAAAAAAAAAAAAAAAAAEBD7+/sM+/v7+/v/+/v7EPsQ+/v7+xD7+/sQ+wAQ/Pv7EPv7EBD7Bvv7+/v7DvsQEPsA+/v8+/0Q+/v/EBAQ+/78/QD7+/sPEPsQ+/v7+/z7DPv7+/z8CPv7+/v7+xD7+xD7EPv7EP/7+/v7+xD7EPsQEPz7+/sO+/v7+/v7EPv7+/z7+/v7EPsQ+/v7+wEQEPsB+wD8+wz7+/v7BPv9+/v7/hACEPz7+/v7+/z7+wgC+wgQ+/wE+/v7EPsQ+/v7+/v8+/v7+xAJOyf08OTg4eDk8PQnOwkAlAAgABljAwMDBhIF9AQY5w34DPv7E1T8uAA0AD5IAgMC5AsM7vsJ6u/3JhAKFkcdwgBHABsAAwMD8Q7gERPkBQ32LgXpPjH4wQBYAD8WAwMDCPT1FhMG/gH0BQs4DkMNzABbAD8WAgMC9fMMAhEO6BffEhknA00PpQBfADulAwMD8BkE3Pny8vYFJQEQHkUW0wB2AEWHAgICCgPo6hb3ADLX/dwA6TfakAB1ABdKAwMDAAP59PjzBQHxFe48EB0r2wCSACnHAgIC7Pn2Awn68+UY9QwB5y4agABzABsBAgMC9e77+wEDDxDwJfwVAg1PwACOACuQAwMD4OgMGw7tAvsYAP4I8x0awgCcAC+QAwMD5f8G8wAB9u0D/uws8CkQrgCZAC9hAwMDBg7o5vsR99vkEAwrwgvdqACiADMRAwMDDvAA9vMQAe8FAwVV9i7/kQCWADMkAgMC8BPlygbf9Pf1Fdki7REGYwCFACkwAwMD2RD63P/88e4YDvoJ6RY6bAC4AA8lAwMDA+35/Q4Q+voIF/kOPjPgVQCSAAcPAwMD5vgH8Abm5vDpCfzoEi/bUACoAC2JAwMD7PL68AzuE/LrIgMOGxw2RQCSAAVeAwMDDPPt/wYEAAUSIPwGLTDKNwBdAB+6AwMD5xIF6f0FCP3jLv8dKiUuSAA9AD9mAwMD/P/z/wwY8QEKJPoXPzbqWABjAB0dAwMD7gIDy/IEAgz4JPUbEx45GwBJAEMlAgIB9Pz4+hT49OsIHPcCSTDknACYADNvAgMCBiTo0wDz8AADGuE0ACHsYwCXAC0BAgMCAPUD5/4T9fr6HvIQ/g43DACXAAMAAQEAAAAAAAAAAAAAAAAAAAAAFABjACEhAQEB8QQA3QsPAvzuGQgZNCobmwCBABFhAQMB9v33APkVE+TqEiQnu+bktQBvAD8+AQMBDOL2DQ4cFQfnBDok0Tr6xwChAC+QAQMB9f31/fgF/Q4eBd40ARcLaACZAC2JAQMB++v19xH4A/sGHvQW9xg8uwCeAC+8AQMB3eoL5fglCObiAPA40RzmzQA7AD+PAQIB8xvw6QD4/PwQIBPvFkUX2wCdACmzAQIB1+YFGBD58/gL9wUN7S0i4ABGAEE8AQEB9AwD7fv3+AD+JQ4XFU4Z7wBXAEN+AQEBAP83AgoP2vzd6fkZC1X49AB3AEc4AQEBBSPl6g3x8/T699fzCUn4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
UID: 3 Template: ZgAAAAABARsAAAAAAAAAAAAAAAAAAAAABVVAAABaqpAAAGr/kAABr//wAAG///AAAb//+AABv+/8AAH/x/gAAf/f9AAB///wAAH/r/AAAH8P4AAACiqAAAAVUQAAAAAAAAAAAAAAAAAAAAAA/Pz+/BT8/Pz8/Pz8/BT8/Pz8/Pz8FPz8/Pz8/Pz8/Pz8/xQKFP8U/Pz8/Pz8/BT8/Pz8/vz8/Pz8/Pz8FPz8FAwU/AT8APwTFP/+/PwA/Pz8BhT8/Pz8/An8/Pz8/AD8/Pz8/PwU/P38/Pz8/f78/vz8/A/8/An/FPwUBBT8/PwF/Pz8/Pz8FP4U/Pz8/RT8/PwU/P38/P38FPwUCPz8/vz8/AD8ABT8/wf8/Pz8/AUK/BT8/PwC/BD/B/38FPz8/P0U/BT8/PwOPSL27OXh4OHl7PYiPQ4AxwA6ABKSAwMD9wn1+gf7/P7vKgIsHDIb1QBPAA2JAgIC4vHxAQ/x/voIDfYb/x40qABPABU8AwMD8PoG2//xA+f6HQMrDkAloABYABbCAgMC8vj9BAYOCAL2CyQSFEgkvAB5ADskAgIC/Eby2gUC6f0D/ewPAiAXxgCUABcVAwMDGfL+/RwbAfsFCPISLD/WogBqABYiAwMDCRv3ERcFAfYBDRL3ES0JnAC3ABF4AwMDAQD8Aewa/xEFE/8gLTbbkgCdABCbAwMDC/fj/Ar7AQTwI/30Ax64jQDCAA8mAwMD+d4L5Qoa9OoBB+4SJy/WdQBnAEKOAwMD/gICEgf3AvfrIf7wEyy8NwBbAB+mAwMD3x0H4PsJ4/YBKRoBG0IjlwApABiyAwMDCP/eAx4A8vT6DgMiGEUZswAwABU8AwMD9A0A7A7y6Oj0Gv8nHEYVjwBIABk8AwMD9RX05gHy59sEBPMbD0MeJABWAEN8AgIC+RMKEQ4K2fT8BvcXKVLkRwAwABwuAgIC+Qrv/hIJ9xb2IhQOKkUHcwBEAD8EAgMC6QsFAwsQ2Qj4JgT7NUnvxgCKABkNAgMC+v/7/vok5v30AuIsDj3LpwBXADlBAQMB7vv3LSn6APHjJg/uIR/KtgBuADeHAQIB6wkAAhfz8hr2/9sG7hThVQC9AAlSAQMBAPECAPIP8/ETFN4VMkPhiwATABlIAQEB9wUO5vwX5f/0HQcUCD4OqwBZABNlAQMB/uHp+RD0IAMGEBEc8yo9uQBqADXEAQMB9PgHBBP58hDt9t4L6BvYsACBADskAQMB+yXr0/v86BAGG/kADjYUzQB9ABt6AQEB7wD40uQr5wvcGPsZ+yfIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
UID: 7 Template: ZQAAAAABASYAAAAAAAAAAAAAAAAAAAAAFVVUAABqqqQAAD//9AAAv//5AAH///kAAf//+AAB//P8AAH/4fQAAf//9AAB/8PwAAG/0/AAAG//0AAAVqqAAABFVQAAAAAAAAAAAAAAAAAAAAAAEBD7+/sM+/v7+/v/+/v7EPsQ+/v7+xD7+/sQ+wAQ/Pv7EPv7EBD7Bvv7+/v7DvsQEPsA+/v8+/0Q+/v/EBAQ+/78/QD7+/sPEPsQ+/v7+/z7DPv7+/z8CPv7+/v7+xD7+xD7EPv7EP/7+/v7+xD7EPsQEPz7+/sO+/v7+/v7EPv7+/z7+/v7EPsQ+/v7+wEQEPsB+wD8+wz7+/v7BPv9+/v7/hACEPz7+/v7+/z7+wgC+wgQ+/wE+/v7EPsQ+/v7+/v8+/v7+xAJOyf08OTg4eDk8PQnOwkAlAAgABljAwMDBhIF9AQY5w34DPv7E1T8uAA0AD5IAgMC5AsM7vsJ6u/3JhAKFkcdwgBHABsAAwMD8Q7gERPkBQ32LgXpPjH4wQBYAD8WAwMDCPT1FhMG/gH0BQs4DkMNzABbAD8WAgMC9fMMAhEO6BffEhknA00PpQBfADulAwMD8BkE3Pny8vYFJQEQHkUW0wB2AEWHAgICCgPo6hb3ADLX/dwA6TfakAB1ABdKAwMDAAP59PjzBQHxFe48EB0r2wCSACnHAgIC7Pn2Awn68+UY9QwB5y4agABzABsBAgMC9e77+wEDDxDwJfwVAg1PwACOACuQAwMD4OgMGw7tAvsYAP4I8x0awgCcAC+QAwMD5f8G8wAB9u0D/uws8CkQrgCZAC9hAwMDBg7o5vsR99vkEAwrwgvdqACiADMRAwMDDvAA9vMQAe8FAwVV9i7/kQCWADMkAgMC8BPlygbf9Pf1Fdki7REGYwCFACkwAwMD2RD63P/88e4YDvoJ6RY6bAC4AA8lAwMDA+35/Q4Q+voIF/kOPjPgVQCSAAcPAwMD5vgH8Abm5vDpCfzoEi/bUACoAC2JAwMD7PL68AzuE/LrIgMOGxw2RQCSAAVeAwMDDPPt/wYEAAUSIPwGLTDKNwBdAB+6AwMD5xIF6f0FCP3jLv8dKiUuSAA9AD9mAwMD/P/z/wwY8QEKJPoXPzbqWABjAB0dAwMD7gIDy/IEAgz4JPUbEx45GwBJAEMlAgIB9Pz4+hT49OsIHPcCSTDknACYADNvAgMCBiTo0wDz8AADGuE0ACHsYwCXAC0BAgMCAPUD5/4T9fr6HvIQ/g43DACXAAMAAQEAAAAAAAAAAAAAAAAAAAAAFABjACEhAQEB8QQA3QsPAvzuGQgZNCobmwCBABFhAQMB9v33APkVE+TqEiQnu+bktQBvAD8+AQMBDOL2DQ4cFQfnBDok0Tr6xwChAC+QAQMB9f31/fgF/Q4eBd40ARcLaACZAC2JAQMB++v19xH4A/sGHvQW9xg8uwCeAC+8AQMB3eoL5fglCObiAPA40RzmzQA7AD+PAQIB8xvw6QD4/PwQIBPvFkUX2wCdACmzAQIB1+YFGBD58/gL9wUN7S0i4ABGAEE8AQEB9AwD7fv3+AD+JQ4XFU4Z7wBXAEN+AQEBAP83AgoP2vzd6fkZC1X49AB3AEc4AQEBBSPl6g3x8/T699fzCUn4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
UID: 8 Template: ZgAAAAABARsAAAAAAAAAAAAAAAAAAAAABVVAAABaqpAAAGr/kAABr//wAAG///AAAb//+AABv+/8AAH/x/gAAf/f9AAB///wAAH/r/AAAH8P4AAACiqAAAAVUQAAAAAAAAAAAAAAAAAAAAAA/Pz+/BT8/Pz8/Pz8/BT8/Pz8/Pz8FPz8/Pz8/Pz8/Pz8/xQKFP8U/Pz8/Pz8/BT8/Pz8/vz8/Pz8/Pz8FPz8FAwU/AT8APwTFP/+/PwA/Pz8BhT8/Pz8/An8/Pz8/AD8/Pz8/PwU/P38/Pz8/f78/vz8/A/8/An/FPwUBBT8/PwF/Pz8/Pz8FP4U/Pz8/RT8/PwU/P38/P38FPwUCPz8/vz8/AD8ABT8/wf8/Pz8/AUK/BT8/PwC/BD/B/38FPz8/P0U/BT8/PwOPSL27OXh4OHl7PYiPQ4AxwA6ABKSAwMD9wn1+gf7/P7vKgIsHDIb1QBPAA2JAgIC4vHxAQ/x/voIDfYb/x40qABPABU8AwMD8PoG2//xA+f6HQMrDkAloABYABbCAgMC8vj9BAYOCAL2CyQSFEgkvAB5ADskAgIC/Eby2gUC6f0D/ewPAiAXxgCUABcVAwMDGfL+/RwbAfsFCPISLD/WogBqABYiAwMDCRv3ERcFAfYBDRL3ES0JnAC3ABF4AwMDAQD8Aewa/xEFE/8gLTbbkgCdABCbAwMDC/fj/Ar7AQTwI/30Ax64jQDCAA8mAwMD+d4L5Qoa9OoBB+4SJy/WdQBnAEKOAwMD/gICEgf3AvfrIf7wEyy8NwBbAB+mAwMD3x0H4PsJ4/YBKRoBG0IjlwApABiyAwMDCP/eAx4A8vT6DgMiGEUZswAwABU8AwMD9A0A7A7y6Oj0Gv8nHEYVjwBIABk8AwMD9RX05gHy59sEBPMbD0MeJABWAEN8AgIC+RMKEQ4K2fT8BvcXKVLkRwAwABwuAgIC+Qrv/hIJ9xb2IhQOKkUHcwBEAD8EAgMC6QsFAwsQ2Qj4JgT7NUnvxgCKABkNAgMC+v/7/vok5v30AuIsDj3LpwBXADlBAQMB7vv3LSn6APHjJg/uIR/KtgBuADeHAQIB6wkAAhfz8hr2/9sG7hThVQC9AAlSAQMBAPECAPIP8/ETFN4VMkPhiwATABlIAQEB9wUO5vwX5f/0HQcUCD4OqwBZABNlAQMB/uHp+RD0IAMGEBEc8yo9uQBqADXEAQMB9PgHBBP58hDt9t4L6BvYsACBADskAQMB+yXr0/v86BAGG/kADjYUzQB9ABt6AQEB7wD40uQr5wvcGPsZ+yfIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
UID: 12 Template: ZQAAAAABASYAAAAAAAAAAAAAAAAAAAAAFVVUAABqqqQAAD//9AAAv//5AAH///kAAf//+AAB//P8AAH/4fQAAf//9AAB/8PwAAG/0/AAAG//0AAAVqqAAABFVQAAAAAAAAAAAAAAAAAAAAAAEBD7+/sM+/v7+/v/+/v7EPsQ+/v7+xD7+/sQ+wAQ/Pv7EPv7EBD7Bvv7+/v7DvsQEPsA+/v8+/0Q+/v/EBAQ+/78/QD7+/sPEPsQ+/v7+/z7DPv7+/z8CPv7+/v7+xD7+xD7EPv7EP/7+/v7+xD7EPsQEPz7+/sO+/v7+/v7EPv7+/z7+/v7EPsQ+/v7+wEQEPsB+wD8+wz7+/v7BPv9+/v7/hACEPz7+/v7+/z7+wgC+wgQ+/wE+/v7EPsQ+/v7+/v8+/v7+xAJOyf08OTg4eDk8PQnOwkAlAAgABljAwMDBhIF9AQY5w34DPv7E1T8uAA0AD5IAgMC5AsM7vsJ6u/3JhAKFkcdwgBHABsAAwMD8Q7gERPkBQ32LgXpPjH4wQBYAD8WAwMDCPT1FhMG/gH0BQs4DkMNzABbAD8WAgMC9fMMAhEO6BffEhknA00PpQBfADulAwMD8BkE3Pny8vYFJQEQHkUW0wB2AEWHAgICCgPo6hb3ADLX/dwA6TfakAB1ABdKAwMDAAP59PjzBQHxFe48EB0r2wCSACnHAgIC7Pn2Awn68+UY9QwB5y4agABzABsBAgMC9e77+wEDDxDwJfwVAg1PwACOACuQAwMD4OgMGw7tAvsYAP4I8x0awgCcAC+QAwMD5f8G8wAB9u0D/uws8CkQrgCZAC9hAwMDBg7o5vsR99vkEAwrwgvdqACiADMRAwMDDvAA9vMQAe8FAwVV9i7/kQCWADMkAgMC8BPlygbf9Pf1Fdki7REGYwCFACkwAwMD2RD63P/88e4YDvoJ6RY6bAC4AA8lAwMDA+35/Q4Q+voIF/kOPjPgVQCSAAcPAwMD5vgH8Abm5vDpCfzoEi/bUACoAC2JAwMD7PL68AzuE/LrIgMOGxw2RQCSAAVeAwMDDPPt/wYEAAUSIPwGLTDKNwBdAB+6AwMD5xIF6f0FCP3jLv8dKiUuSAA9AD9mAwMD/P/z/wwY8QEKJPoXPzbqWABjAB0dAwMD7gIDy/IEAgz4JPUbEx45GwBJAEMlAgIB9Pz4+hT49OsIHPcCSTDknACYADNvAgMCBiTo0wDz8AADGuE0ACHsYwCXAC0BAgMCAPUD5/4T9fr6HvIQ/g43DACXAAMAAQEAAAAAAAAAAAAAAAAAAAAAFABjACEhAQEB8QQA3QsPAvzuGQgZNCobmwCBABFhAQMB9v33APkVE+TqEiQnu+bktQBvAD8+AQMBDOL2DQ4cFQfnBDok0Tr6xwChAC+QAQMB9f31/fgF/Q4eBd40ARcLaACZAC2JAQMB++v19xH4A/sGHvQW9xg8uwCeAC+8AQMB3eoL5fglCObiAPA40RzmzQA7AD+PAQIB8xvw6QD4/PwQIBPvFkUX2wCdACmzAQIB1+YFGBD58/gL9wUN7S0i4ABGAEE8AQEB9AwD7fv3+AD+JQ4XFU4Z7wBXAEN+AQEBAP83AgoP2vzd6fkZC1X49AB3AEc4AQEBBSPl6g3x8/T699fzCUn4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
UID: 13 Template: ZgAAAAABARsAAAAAAAAAAAAAAAAAAAAABVVAAABaqpAAAGr/kAABr//wAAG///AAAb//+AABv+/8AAH/x/gAAf/f9AAB///wAAH/r/AAAH8P4AAACiqAAAAVUQAAAAAAAAAAAAAAAAAAAAAA/Pz+/BT8/Pz8/Pz8/BT8/Pz8/Pz8FPz8/Pz8/Pz8/Pz8/xQKFP8U/Pz8/Pz8/BT8/Pz8/vz8/Pz8/Pz8FPz8FAwU/AT8APwTFP/+/PwA/Pz8BhT8/Pz8/An8/Pz8/AD8/Pz8/PwU/P38/Pz8/f78/vz8/A/8/An/FPwUBBT8/PwF/Pz8/Pz8FP4U/Pz8/RT8/PwU/P38/P38FPwUCPz8/vz8/AD8ABT8/wf8/Pz8/AUK/BT8/PwC/BD/B/38FPz8/P0U/BT8/PwOPSL27OXh4OHl7PYiPQ4AxwA6ABKSAwMD9wn1+gf7/P7vKgIsHDIb1QBPAA2JAgIC4vHxAQ/x/voIDfYb/x40qABPABU8AwMD8PoG2//xA+f6HQMrDkAloABYABbCAgMC8vj9BAYOCAL2CyQSFEgkvAB5ADskAgIC/Eby2gUC6f0D/ewPAiAXxgCUABcVAwMDGfL+/RwbAfsFCPISLD/WogBqABYiAwMDCRv3ERcFAfYBDRL3ES0JnAC3ABF4AwMDAQD8Aewa/xEFE/8gLTbbkgCdABCbAwMDC/fj/Ar7AQTwI/30Ax64jQDCAA8mAwMD+d4L5Qoa9OoBB+4SJy/WdQBnAEKOAwMD/gICEgf3AvfrIf7wEyy8NwBbAB+mAwMD3x0H4PsJ4/YBKRoBG0IjlwApABiyAwMDCP/eAx4A8vT6DgMiGEUZswAwABU8AwMD9A0A7A7y6Oj0Gv8nHEYVjwBIABk8AwMD9RX05gHy59sEBPMbD0MeJABWAEN8AgIC+RMKEQ4K2fT8BvcXKVLkRwAwABwuAgIC+Qrv/hIJ9xb2IhQOKkUHcwBEAD8EAgMC6QsFAwsQ2Qj4JgT7NUnvxgCKABkNAgMC+v/7/vok5v30AuIsDj3LpwBXADlBAQMB7vv3LSn6APHjJg/uIR/KtgBuADeHAQIB6wkAAhfz8hr2/9sG7hThVQC9AAlSAQMBAPECAPIP8/ETFN4VMkPhiwATABlIAQEB9wUO5vwX5f/0HQcUCD4OqwBZABNlAQMB/uHp+RD0IAMGEBEc8yo9uQBqADXEAQMB9PgHBBP58hDt9t4L6BvYsACBADskAQMB+yXr0/v86BAGG/kADjYUzQB9ABt6AQEB7wD40uQr5wvcGPsZ+yfIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
UID: 17 Template: ZQAAAAABASYAAAAAAAAAAAAAAAAAAAAAFVVUAABqqqQAAD//9AAAv//5AAH///kAAf//+AAB//P8AAH/4fQAAf//9AAB/8PwAAG/0/AAAG//0AAAVqqAAABFVQAAAAAAAAAAAAAAAAAAAAAAEBD7+/sM+/v7+/v/+/v7EPsQ+/v7+xD7+/sQ+wAQ/Pv7EPv7EBD7Bvv7+/v7DvsQEPsA+/v8+/0Q+/v/EBAQ+/78/QD7+/sPEPsQ+/v7+/z7DPv7+/z8CPv7+/v7+xD7+xD7EPv7EP/7+/v7+xD7EPsQEPz7+/sO+/v7+/v7EPv7+/z7+/v7EPsQ+/v7+wEQEPsB+wD8+wz7+/v7BPv9+/v7/hACEPz7+/v7+/z7+wgC+wgQ+/wE+/v7EPsQ+/v7+/v8+/v7+xAJOyf08OTg4eDk8PQnOwkAlAAgABljAwMDBhIF9AQY5w34DPv7E1T8uAA0AD5IAgMC5AsM7vsJ6u/3JhAKFkcdwgBHABsAAwMD8Q7gERPkBQ32LgXpPjH4wQBYAD8WAwMDCPT1FhMG/gH0BQs4DkMNzABbAD8WAgMC9fMMAhEO6BffEhknA00PpQBfADulAwMD8BkE3Pny8vYFJQEQHkUW0wB2AEWHAgICCgPo6hb3ADLX/dwA6TfakAB1ABdKAwMDAAP59PjzBQHxFe48EB0r2wCSACnHAgIC7Pn2Awn68+UY9QwB5y4agABzABsBAgMC9e77+wEDDxDwJfwVAg1PwACOACuQAwMD4OgMGw7tAvsYAP4I8x0awgCcAC+QAwMD5f8G8wAB9u0D/uws8CkQrgCZAC9hAwMDBg7o5vsR99vkEAwrwgvdqACiADMRAwMDDvAA9vMQAe8FAwVV9i7/kQCWADMkAgMC8BPlygbf9Pf1Fdki7REGYwCFACkwAwMD2RD63P/88e4YDvoJ6RY6bAC4AA8lAwMDA+35/Q4Q+voIF/kOPjPgVQCSAAcPAwMD5vgH8Abm5vDpCfzoEi/bUACoAC2JAwMD7PL68AzuE/LrIgMOGxw2RQCSAAVeAwMDDPPt/wYEAAUSIPwGLTDKNwBdAB+6AwMD5xIF6f0FCP3jLv8dKiUuSAA9AD9mAwMD/P/z/wwY8QEKJPoXPzbqWABjAB0dAwMD7gIDy/IEAgz4JPUbEx45GwBJAEMlAgIB9Pz4+hT49OsIHPcCSTDknACYADNvAgMCBiTo0wDz8AADGuE0ACHsYwCXAC0BAgMCAPUD5/4T9fr6HvIQ/g43DACXAAMAAQEAAAAAAAAAAAAAAAAAAAAAFABjACEhAQEB8QQA3QsPAvzuGQgZNCobmwCBABFhAQMB9v33APkVE+TqEiQnu+bktQBvAD8+AQMBDOL2DQ4cFQfnBDok0Tr6xwChAC+QAQMB9f31/fgF/Q4eBd40ARcLaACZAC2JAQMB++v19xH4A/sGHvQW9xg8uwCeAC+8AQMB3eoL5fglCObiAPA40RzmzQA7AD+PAQIB8xvw6QD4/PwQIBPvFkUX2wCdACmzAQIB1+YFGBD58/gL9wUN7S0i4ABGAEE8AQEB9AwD7fv3+AD+JQ4XFU4Z7wBXAEN+AQEBAP83AgoP2vzd6fkZC1X49AB3AEc4AQEBBSPl6g3x8/T699fzCUn4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
UID: 18 Template: ZgAAAAABARsAAAAAAAAAAAAAAAAAAAAABVVAAABaqpAAAGr/kAABr//wAAG///AAAb//+AABv+/8AAH/x/gAAf/f9AAB///wAAH/r/AAAH8P4AAACiqAAAAVUQAAAAAAAAAAAAAAAAAAAAAA/Pz+/BT8/Pz8/Pz8/BT8/Pz8/Pz8FPz8/Pz8/Pz8/Pz8/xQKFP8U/Pz8/Pz8/BT8/Pz8/vz8/Pz8/Pz8FPz8FAwU/AT8APwTFP/+/PwA/Pz8BhT8/Pz8/An8/Pz8/AD8/Pz8/PwU/P38/Pz8/f78/vz8/A/8/An/FPwUBBT8/PwF/Pz8/Pz8FP4U/Pz8/RT8/PwU/P38/P38FPwUCPz8/vz8/AD8ABT8/wf8/Pz8/AUK/BT8/PwC/BD/B/38FPz8/P0U/BT8/PwOPSL27OXh4OHl7PYiPQ4AxwA6ABKSAwMD9wn1+gf7/P7vKgIsHDIb1QBPAA2JAgIC4vHxAQ/x/voIDfYb/x40qABPABU8AwMD8PoG2//xA+f6HQMrDkAloABYABbCAgMC8vj9BAYOCAL2CyQSFEgkvAB5ADskAgIC/Eby2gUC6f0D/ewPAiAXxgCUABcVAwMDGfL+/RwbAfsFCPISLD/WogBqABYiAwMDCRv3ERcFAfYBDRL3ES0JnAC3ABF4AwMDAQD8Aewa/xEFE/8gLTbbkgCdABCbAwMDC/fj/Ar7AQTwI/30Ax64jQDCAA8mAwMD+d4L5Qoa9OoBB+4SJy/WdQBnAEKOAwMD/gICEgf3AvfrIf7wEyy8NwBbAB+mAwMD3x0H4PsJ4/YBKRoBG0IjlwApABiyAwMDCP/eAx4A8vT6DgMiGEUZswAwABU8AwMD9A0A7A7y6Oj0Gv8nHEYVjwBIABk8AwMD9RX05gHy59sEBPMbD0MeJABWAEN8AgIC+RMKEQ4K2fT8BvcXKVLkRwAwABwuAgIC+Qrv/hIJ9xb2IhQOKkUHcwBEAD8EAgMC6QsFAwsQ2Qj4JgT7NUnvxgCKABkNAgMC+v/7/vok5v30AuIsDj3LpwBXADlBAQMB7vv3LSn6APHjJg/uIR/KtgBuADeHAQIB6wkAAhfz8hr2/9sG7hThVQC9AAlSAQMBAPECAPIP8/ETFN4VMkPhiwATABlIAQEB9wUO5vwX5f/0HQcUCD4OqwBZABNlAQMB/uHp+RD0IAMGEBEc8yo9uQBqADXEAQMB9PgHBBP58hDt9t4L6BvYsACBADskAQMB+yXr0/v86BAGG/kADjYUzQB9ABt6AQEB7wD40uQr5wvcGPsZ+yfIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
UID: 22 Template: ZQAAAAABASYAAAAAAAAAAAAAAAAAAAAAFVVUAABqqqQAAD//9AAAv//5AAH///kAAf//+AAB//P8AAH/4fQAAf//9AAB/8PwAAG/0/AAAG//0AAAVqqAAABFVQAAAAAAAAAAAAAAAAAAAAAAEBD7+/sM+/v7+/v/+/v7EPsQ+/v7+xD7+/sQ+wAQ/Pv7EPv7EBD7Bvv7+/v7DvsQEPsA+/v8+/0Q+/v/EBAQ+/78/QD7+/sPEPsQ+/v7+/z7DPv7+/z8CPv7+/v7+xD7+xD7EPv7EP/7+/v7+xD7EPsQEPz7+/sO+/v7+/v7EPv7+/z7+/v7EPsQ+/v7+wEQEPsB+wD8+wz7+/v7BPv9+/v7/hACEPz7+/v7+/z7+wgC+wgQ+/wE+/v7EPsQ+/v7+/v8+/v7+xAJOyf08OTg4eDk8PQnOwkAlAAgABljAwMDBhIF9AQY5w34DPv7E1T8uAA0AD5IAgMC5AsM7vsJ6u/3JhAKFkcdwgBHABsAAwMD8Q7gERPkBQ32LgXpPjH4wQBYAD8WAwMDCPT1FhMG/gH0BQs4DkMNzABbAD8WAgMC9fMMAhEO6BffEhknA00PpQBfADulAwMD8BkE3Pny8vYFJQEQHkUW0wB2AEWHAgICCgPo6hb3ADLX/dwA6TfakAB1ABdKAwMDAAP59PjzBQHxFe48EB0r2wCSACnHAgIC7Pn2Awn68+UY9QwB5y4agABzABsBAgMC9e77+wEDDxDwJfwVAg1PwACOACuQAwMD4OgMGw7tAvsYAP4I8x0awgCcAC+QAwMD5f8G8wAB9u0D/uws8CkQrgCZAC9hAwMDBg7o5vsR99vkEAwrwgvdqACiADMRAwMDDvAA9vMQAe8FAwVV9i7/kQCWADMkAgMC8BPlygbf9Pf1Fdki7REGYwCFACkwAwMD2RD63P/88e4YDvoJ6RY6bAC4AA8lAwMDA+35/Q4Q+voIF/kOPjPgVQCSAAcPAwMD5vgH8Abm5vDpCfzoEi/bUACoAC2JAwMD7PL68AzuE/LrIgMOGxw2RQCSAAVeAwMDDPPt/wYEAAUSIPwGLTDKNwBdAB+6AwMD5xIF6f0FCP3jLv8dKiUuSAA9AD9mAwMD/P/z/wwY8QEKJPoXPzbqWABjAB0dAwMD7gIDy/IEAgz4JPUbEx45GwBJAEMlAgIB9Pz4+hT49OsIHPcCSTDknACYADNvAgMCBiTo0wDz8AADGuE0ACHsYwCXAC0BAgMCAPUD5/4T9fr6HvIQ/g43DACXAAMAAQEAAAAAAAAAAAAAAAAAAAAAFABjACEhAQEB8QQA3QsPAvzuGQgZNCobmwCBABFhAQMB9v33APkVE+TqEiQnu+bktQBvAD8+AQMBDOL2DQ4cFQfnBDok0Tr6xwChAC+QAQMB9f31/fgF/Q4eBd40ARcLaACZAC2JAQMB++v19xH4A/sGHvQW9xg8uwCeAC+8AQMB3eoL5fglCObiAPA40RzmzQA7AD+PAQIB8xvw6QD4/PwQIBPvFkUX2wCdACmzAQIB1+YFGBD58/gL9wUN7S0i4ABGAEE8AQEB9AwD7fv3+AD+JQ4XFU4Z7wBXAEN+AQEBAP83AgoP2vzd6fkZC1X49AB3AEc4AQEBBSPl6g3x8/T699fzCUn4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
UID: 27 Template: ZQAAAAABASYAAAAAAAAAAAAAAAAAAAAAFVVUAABqqqQAAD//9AAAv//5AAH///kAAf//+AAB//P8AAH/4fQAAf//9AAB/8PwAAG/0/AAAG//0AAAVqqAAABFVQAAAAAAAAAAAAAAAAAAAAAAEBD7+/sM+/v7+/v/+/v7EPsQ+/v7+xD7+/sQ+wAQ/Pv7EPv7EBD7Bvv7+/v7DvsQEPsA+/v8+/0Q+/v/EBAQ+/78/QD7+/sPEPsQ+/v7+/z7DPv7+/z8CPv7+/v7+xD7+xD7EPv7EP/7+/v7+xD7EPsQEPz7+/sO+/v7+/v7EPv7+/z7+/v7EPsQ+/v7+wEQEPsB+wD8+wz7+/v7BPv9+/v7/hACEPz7+/v7+/z7+wgC+wgQ+/wE+/v7EPsQ+/v7+/v8+/v7+xAJOyf08OTg4eDk8PQnOwkAlAAgABljAwMDBhIF9AQY5w34DPv7E1T8uAA0AD5IAgMC5AsM7vsJ6u/3JhAKFkcdwgBHABsAAwMD8Q7gERPkBQ32LgXpPjH4wQBYAD8WAwMDCPT1FhMG/gH0BQs4DkMNzABbAD8WAgMC9fMMAhEO6BffEhknA00PpQBfADulAwMD8BkE3Pny8vYFJQEQHkUW0wB2AEWHAgICCgPo6hb3ADLX/dwA6TfakAB1ABdKAwMDAAP59PjzBQHxFe48EB0r2wCSACnHAgIC7Pn2Awn68+UY9QwB5y4agABzABsBAgMC9e77+wEDDxDwJfwVAg1PwACOACuQAwMD4OgMGw7tAvsYAP4I8x0awgCcAC+QAwMD5f8G8wAB9u0D/uws8CkQrgCZAC9hAwMDBg7o5vsR99vkEAwrwgvdqACiADMRAwMDDvAA9vMQAe8FAwVV9i7/kQCWADMkAgMC8BPlygbf9Pf1Fdki7REGYwCFACkwAwMD2RD63P/88e4YDvoJ6RY6bAC4AA8lAwMDA+35/Q4Q+voIF/kOPjPgVQCSAAcPAwMD5vgH8Abm5vDpCfzoEi/bUACoAC2JAwMD7PL68AzuE/LrIgMOGxw2RQCSAAVeAwMDDPPt/wYEAAUSIPwGLTDKNwBdAB+6AwMD5xIF6f0FCP3jLv8dKiUuSAA9AD9mAwMD/P/z/wwY8QEKJPoXPzbqWABjAB0dAwMD7gIDy/IEAgz4JPUbEx45GwBJAEMlAgIB9Pz4+hT49OsIHPcCSTDknACYADNvAgMCBiTo0wDz8AADGuE0ACHsYwCXAC0BAgMCAPUD5/4T9fr6HvIQ/g43DACXAAMAAQEAAAAAAAAAAAAAAAAAAAAAFABjACEhAQEB8QQA3QsPAvzuGQgZNCobmwCBABFhAQMB9v33APkVE+TqEiQnu+bktQBvAD8+AQMBDOL2DQ4cFQfnBDok0Tr6xwChAC+QAQMB9f31/fgF/Q4eBd40ARcLaACZAC2JAQMB++v19xH4A/sGHvQW9xg8uwCeAC+8AQMB3eoL5fglCObiAPA40RzmzQA7AD+PAQIB8xvw6QD4/PwQIBPvFkUX2wCdACmzAQIB1+YFGBD58/gL9wUN7S0i4ABGAEE8AQEB9AwD7fv3+AD+JQ4XFU4Z7wBXAEN+AQEBAP83AgoP2vzd6fkZC1X49AB3AEc4AQEBBSPl6g3x8/T699fzCUn4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

 */
	@Before
	public void setUp() throws Exception {
		try {
			mSws = new SynergyWebServices();
			mFps = mSws.getFingerPrints();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFingerprint() {
		FingerPrintDao fpDao = new HbmFingerPrintDao();
		FingerPrintPOJO fp = fpDao.getFingerprint(200, 0);
		System.out.println(fp.toString());
	}
	
	@Test
	public void testSaveFingerprint(){
		System.out.println("Template len: "+fpsample.length());
		FingerPrintPOJO fp = new FingerPrintPOJO();
		fp.setFingerNum(0);
		fp.setUserId(200);
		fp.setTemplate(fpsample);
		FingerPrintDao fpDao = new HbmFingerPrintDao();
		fpDao.saveFingerprint(fp);
	}

	@Test
	public void testSaveFingerprints() {
		List<FingerPrintPOJO> fps = convertToFingerPrintPOJO(mFps);
		FingerPrintDao fpDao = new HbmFingerPrintDao();
		fpDao.saveFingerprints(fps);
	}
	
	private List<FingerPrintPOJO> convertToFingerPrintPOJO(List<Fingerprint> fps) {
		List<FingerPrintPOJO> aofp = new ArrayList<FingerPrintPOJO>();
		for(Fingerprint fp:fps){
			uId = fp.getUserId();
			String tmp = fp.getTemplate();
			FingerPrintPOJO e = new FingerPrintPOJO();
			e.setUserId(uId);
			e.setFingerNum(0);
			e.setTemplate(tmp);
			aofp.add(e);
			System.out.println("UID: "+uId+" Template: "+tmp);
		}
		return aofp;
	}
}